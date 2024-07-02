package himedia.myportal.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "c:/uploads";

	// 멀티파트 파일을 실제 파일로 저장하는 메서드
	public String store(MultipartFile multipartFile) {
		// 파일 명 확인
		String originalFilename = multipartFile.getOriginalFilename();
		// 확장자 분리
		String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
		String saveFilename = getSaveFilename(extName);

		System.out.println("New Filename: " + saveFilename);

		try {
			writeFile(multipartFile, saveFilename);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return saveFilename;

	}

	// 멀티파트 파일을 전달 받아서 실제 저장소에 저장하는 유틸리티 함수
	private void writeFile(MultipartFile multipartFile, String saveFilename) throws IOException {
		// 멀티파트 파일에서 바이트 데이터 가져오기
		byte[] fileData = multipartFile.getBytes();
		// 출력 스트림 설정
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		// 출력 스트림으로 출력
		fos.write(fileData);
		// 버퍼 비우기
		fos.flush();
		// 출력 스트림 정리
		fos.close();
	}

	// 확장자를 전달 받아서 임시파일명을 만드는 함수
	public String getSaveFilename(String extName) {

		// 현재시간을 밀리세컨드로 변환해서 파일명으로 삼음
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis()) + extName.toLowerCase();
	}
}
