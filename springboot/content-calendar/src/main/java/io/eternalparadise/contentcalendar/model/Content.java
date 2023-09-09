package io.eternalparadise.contentcalendar.model;

// import io.eternalparadise.contentcalendar.Type;
// import io.eternalparadise.contentcalendar.Status;

import java.time.LocalDateTime;

public record Content(
	Integer id,
	String title,
	String desc,
	Status status,
	Type contentType,
	LocalDateTime dateCreated,
	LocalDateTime dateUpdated,
	String url
) {}
