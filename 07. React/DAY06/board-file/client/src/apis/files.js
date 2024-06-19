import axios from "axios";

// 파일 업로드
export const upload = (formData, headers) => axios.post(`/files`, formData, headers);

// 파일 다운로드
export const download = (no) => axios.get(`/files/${no}`, {responseType: 'blob'}) // blob(비랍..?) 타입으로 지정해줘야 파일 데이터를 받아올 수 있음

// 파일 삭제
export const remove = (fileNo) => axios.delete(`/files/${fileNo}`);

// 파일 선택 삭제
export const removeFiles = (fileNos) => axios.delete(`/files?no=${fileNos}`)