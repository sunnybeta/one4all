package io.eternalparadise.contentcalendar.repository;

import io.eternalparadise.contentcalendar.model.Content;
import io.eternalparadise.contentcalendar.model.Status;
import io.eternalparadise.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {
	private final List<Content> contentList = new ArrayList<>();

	public ContentCollectionRepository() {
	}

	public List<Content> findAll() {
		return contentList;
	}

	public Optional<Content> findById(Integer id) {
		return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
	}

	public void save(Content content) {
		contentList.removeIf(c -> c.id().equals(content.id()));
		contentList.add(content);
	}

	public boolean existsById(Integer id) {
		return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
	}

	public void removeById(Integer id) {
		contentList.removeIf(c -> c.id().equals(id));
	}

	@PostConstruct
	private void init() {
		Content c = new Content(
			1,
			"My First Blog Post",
			"My First Blog Post",
			Status.IDEA,
			Type.ARTICLE,
			LocalDateTime.now(),
			null,
			""
		);
		contentList.add(c);
	}
}
