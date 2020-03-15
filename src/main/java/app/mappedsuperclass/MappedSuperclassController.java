package app.mappedsuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mapped-superclass")
public class MappedSuperclassController {

	@Autowired
	TagRepository tagRepository;

	@PostMapping
	public Tag create() {
		return tagRepository.save(Tag.builder().name("tag1").build());
	}

	@GetMapping
	public List<Tag> get() {
		return tagRepository.findAll();
	}
}