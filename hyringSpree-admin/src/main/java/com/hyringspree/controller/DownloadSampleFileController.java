package com.hyringspree.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyringspree.model.Job;
import com.hyringspree.util.IConstant;

//@CrossOrigin
@RestController
public class DownloadSampleFileController {

	/**
	 * downloadSampleCSV
	 * 
	 * @param String
	 *            fileName
	 * @return
	 */
	@PostMapping(path = IConstant.DOWNLOAD_SAMPLE_CSV)
	public ResponseEntity<?> downloadSampleCSV(@RequestBody String sampleCSVFileName) {

		Job job = new Job();
		job.setSampleCSVFileName(sampleCSVFileName.replace("\"", ""));

		FileInputStream fileInputStream = null;
		byte[] bytesArray = null;

		try {
			// File file = new File("/home/aartek/jobs.xml");
			File file = new File(IConstant.SAMPLE_CSV_FILENAME_WITHPATH + File.separator + job.getSampleCSVFileName());

			bytesArray = new byte[(int) file.length()];

			// read file into bytes[]
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bytesArray);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		return new ResponseEntity<byte[]>(bytesArray, headers, HttpStatus.OK);
	}

}
