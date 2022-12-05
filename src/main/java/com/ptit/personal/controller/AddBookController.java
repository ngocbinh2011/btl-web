package com.ptit.personal.controller;

import com.ptit.personal.config.AppConfig;
import com.ptit.personal.entity.Book;
import com.ptit.personal.service.IBookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@AllArgsConstructor
@Controller
@Slf4j
public class AddBookController {

    private final IBookService bookService;
    private final AppConfig appConfig;

    @PostMapping("/books/{id}")
    public String saveBook(@Valid @ModelAttribute("book") Book book,
                           BindingResult resuilt,
                           @PathVariable String id,
                           @RequestParam("coverImg") MultipartFile multipartFile) throws IOException {
        try {
            if (resuilt.hasErrors()) {
                return "book-details";
            }

            if (!multipartFile.isEmpty()) {
                String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
                book.setCover(fileName);

                String uploadDir = "./" + appConfig.getFileUploadPath() + "/";
                Path uploadPath = Paths.get(uploadDir);

                try {
                    InputStream inputStream = multipartFile.getInputStream();
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ioe) {
                    log.info("Error " + ioe.getMessage(), ioe);
                }
            }

            bookService.saveBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
