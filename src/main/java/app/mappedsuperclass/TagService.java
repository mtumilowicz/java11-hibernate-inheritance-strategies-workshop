package app.mappedsuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TagService {

    @Autowired
    TagRepository tagRepository;

    Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    List<Tag> findAll() {
        return tagRepository.findAll();
    }

    void deleteAll() {
    	tagRepository.deleteAll();
	}
}