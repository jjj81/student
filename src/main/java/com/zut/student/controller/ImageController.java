package com.zut.student.controller;

import java.io.File;

import com.zut.student.mapper.StudentDoExerciseInfoMapper;
import com.zut.student.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/emage")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@Autowired
	private StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@GetMapping("/search")
	String updadateImage(@RequestParam("url") String url, @RequestParam("account") String account, Model model,
			@RequestParam("studentId") String studentId) {

		model.addAttribute("studentId", studentId);
		model.addAttribute("url", url);
		model.addAttribute("account", account);
		model.addAttribute("base64Photo1",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("base64Photo2",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("base64Photo3",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("base64Photo4",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("base64Photo5",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto5());

		return "imageInfo";
	}

	@PostMapping("/upload1")
	String uploadImage(@RequestParam("url") String url, @RequestParam("account") String account, Model model,
			@RequestParam("image") MultipartFile image, @RequestParam("id") String studentId) {
		String base64;
		File file = new File("/home/jsw/project/java/student/src/main/resources/static/images/1.png");
		base64 = imageService.fileToBase64(imageService.multipartFileToFile(image, file));
		studentDoExerciseInfoMapper.updateImage(base64, url, account);

		model.addAttribute("base64Photo1",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("base64Photo2",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("base64Photo3",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("base64Photo4",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("base64Photo5",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto5());

		model.addAttribute("studentId", studentId);
		model.addAttribute("url", url);
		model.addAttribute("account", account);
		return "imageInfo";
	}

	@PostMapping("/upload2")
	String uploadImage2(@RequestParam("url") String url, @RequestParam("account") String account, Model model,
			@RequestParam("image") MultipartFile image, @RequestParam("id") String studentId) {
		String base64;
		File file = new File("/home/jsw/project/java/student/src/main/resources/static/images/1.png");
		base64 = imageService.fileToBase64(imageService.multipartFileToFile(image, file));
		studentDoExerciseInfoMapper.updateImage2(base64, url, account);

		model.addAttribute("base64Photo1",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("base64Photo2",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("base64Photo3",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("base64Photo4",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("base64Photo5",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto5());

		model.addAttribute("studentId", studentId);
		model.addAttribute("url", url);
		model.addAttribute("account", account);
		return "imageInfo";
	}

	@PostMapping("/upload3")
	String uploadImage3(@RequestParam("url") String url, @RequestParam("account") String account, Model model,
			@RequestParam("image") MultipartFile image, @RequestParam("id") String studentId) {
		String base64;
		File file = new File("/home/jsw/project/java/student/src/main/resources/static/images/1.png");
		base64 = imageService.fileToBase64(imageService.multipartFileToFile(image, file));
		studentDoExerciseInfoMapper.updateImage3(base64, url, account);

		model.addAttribute("base64Photo1",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("base64Photo2",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("base64Photo3",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("base64Photo4",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("base64Photo5",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto5());

		model.addAttribute("studentId", studentId);
		model.addAttribute("url", url);
		model.addAttribute("account", account);
		return "imageInfo";
	}

	@PostMapping("/upload4")
	String uploadImage4(@RequestParam("url") String url, @RequestParam("account") String account, Model model,
			@RequestParam("image") MultipartFile image, @RequestParam("id") String studentId) {
		String base64;
		File file = new File("/home/jsw/project/java/student/src/main/resources/static/images/1.png");
		base64 = imageService.fileToBase64(imageService.multipartFileToFile(image, file));
		studentDoExerciseInfoMapper.updateImage4(base64, url, account);

		model.addAttribute("base64Photo1",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("base64Photo2",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("base64Photo3",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("base64Photo4",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("base64Photo5",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto5());

		model.addAttribute("studentId", studentId);
		model.addAttribute("url", url);
		model.addAttribute("account", account);
		return "imageInfo";
	}

	@PostMapping("/upload5")
	String uploadImage5(@RequestParam("url") String url, @RequestParam("account") String account, Model model,
			@RequestParam("image") MultipartFile image, @RequestParam("id") String studentId) {
		String base64;
		File file = new File("/home/jsw/project/java/student/src/main/resources/static/images/1.png");
		base64 = imageService.fileToBase64(imageService.multipartFileToFile(image, file));
		studentDoExerciseInfoMapper.updateImage5(base64, url, account);

		model.addAttribute("base64Photo1",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("base64Photo2",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("base64Photo3",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("base64Photo4",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("base64Photo5",
				studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExercisePhoto5());

		model.addAttribute("studentId", studentId);
		model.addAttribute("url", url);
		model.addAttribute("account", account);
		return "imageInfo";
	}

}
