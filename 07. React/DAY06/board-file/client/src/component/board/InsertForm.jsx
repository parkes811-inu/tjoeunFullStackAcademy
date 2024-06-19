import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import styles from '../css/insert.module.css';
import * as filesAPI from '../../apis/files';
// CKEditor5
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

const InsertForm = ({ onInsert }) => {
  // 🧊 상태
  const [title, setTitle] = useState(''); 
  const [writer, setWriter] = useState(''); 
  const [content, setContent] = useState(''); 
  const [files, setFiles] = useState(null);  // 파일 입력 상태

  // 🌞 이벤트 핸들러
  const handleChangeTitle = (e) => setTitle(e.target.value);
  const handleChangeWriter = (e) => setWriter(e.target.value);
  const handleChangeFile = (e) => setFiles(e.target.files);

  // 🌞 폼 제출 핸들러
  const onSubmit = () => {
    const formData = new FormData();
    formData.append('title', title); 
    formData.append('writer', writer); 
    formData.append('content', content); 

    // 📄 파일 데이터를 formData에 추가
    if (files) {
      for (let i = 0; i < files.length; i++) {
        formData.append('files', files[i]);
      }
    }

    const headers = {
      'Content-Type': 'multipart/form-data'
    };

    // onInsert 함수를 formData와 헤더와 함께 호출
    onInsert(formData, headers);
  }

  // 🌞 CKEditor용 커스텀 파일 업로드 어댑터
  const customUploadAdapter = (loader) => {
    return {
      upload() {
        return new Promise((resolve, reject) => {
          const formData = new FormData();
          loader.file.then(async (file) => {
            formData.append('parentTable', 'editor');
            formData.append('file', file);

            const headers = {
              'Content-Type': 'multipart/form-data',
            };

            try {
              const response = await filesAPI.upload(formData, headers);
              const data = await response.data;
              console.log(`data : ${data}`);
              
              const newFile = data;
              const newFileNo = newFile.no;

              // 이미지 렌더링
              await resolve({
                  default: `http://localhost:8080/files/img/${newFileNo}`
              });
            } catch (error) {
              reject(error);
            }
          });
        });
      },
    };
  };

  // 🌞 CKEditor 설정
  function uploadPlugin(editor) {
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
      return customUploadAdapter(loader);
    };
  }

  return (
    <div className='container'>
      <h1 className='title'>게시글 등록</h1>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>제목</td>
            <td>
              {/* CSS module의 클래스 선택자는 카멜케이스로 쓰는 것이 관례 */}
              <input type='text' 
                     className={styles['form-input']}
                     value={title}
                     onChange={handleChangeTitle} />
            </td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>
              <input type="text" 
                     className={styles['form-input']}
                     value={writer}
                     onChange={handleChangeWriter} />
            </td>
          </tr>
          <tr>
            <td colSpan={2}>내용</td>
          </tr>
          <tr>
            <td colSpan={2}>
              <CKEditor
                editor={ClassicEditor}
                config={{
                  placeholder: "내용을 입력하세요.",
                  toolbar: {
                    items: [
                      'undo', 'redo',
                      '|', 'heading',
                      '|', 'fontfamily', 'fontsize', 'fontColor', 'fontBackgroundColor',
                      '|', 'bold', 'italic', 'strikethrough', 'subscript', 'superscript', 'code',
                      '|', 'bulletedList', 'numberedList', 'todoList', 'outdent', 'indent',
                      '|', 'link', 'uploadImage', 'blockQuote', 'codeBlock',
                      '|', 'mediaEmbed',
                    ],
                    shouldNotGroupWhenFull: false
                  },
                  editorConfig: {
                    height: 500, // 원하는 높이 (픽셀 단위) 설정
                  },
                  alignment: {
                    options: ['left', 'center', 'right', 'justify'],
                  },
                  extraPlugins: [uploadPlugin]  // 업로드 플러그인 추가
                }}
                data=""
                onReady={editor => {
                  console.log('Editor is ready to use!', editor);
                }}
                onChange={(event, editor) => {
                  const data = editor.getData();
                  console.log({ event, editor, data });
                  setContent(data);
                }}
                onBlur={(event, editor) => {
                  console.log('Blur.', editor);
                }}
                onFocus={(event, editor) => {
                  console.log('Focus.', editor);
                }}
              />
            </td>
          </tr>
          <tr>
            <td>파일</td>
            <td colSpan={2}>
              <input type="file" onChange={handleChangeFile} multiple />
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn-box'>
        <Link to="/boards" className='btn'>목록</Link>
        <button className='btn' onClick={onSubmit}>등록</button>
      </div>
    </div>
  );
}

export default InsertForm;
