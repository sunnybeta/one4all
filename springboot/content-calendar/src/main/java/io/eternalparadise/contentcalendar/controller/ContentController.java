package io.eternalparadise.contentcalendar.controller;

import io.eternalparadise.contentcalendar.model.Content;
import io.eternalparadise.contentcalendar.repository.ContentCollectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/contents")
public class ContentController {
	private final ContentCollectionRepository repository;

	@Autowired
	public ContentController(ContentCollectionRepository contentCollectionRepository) {
		this.repository = contentCollectionRepository;
	}

	@GetMapping("")
	public List<Content> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Content> findContentById(@PathVariable Integer id) {
		return repository.findById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void createContent(@RequestBody Content content) {
		repository.save(content);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	public void updateContent(@RequestBody Content content, Integer id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
		}
		repository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void updateContent(@PathVariable Integer id) {
		repository.removeById(id);
	}

}
