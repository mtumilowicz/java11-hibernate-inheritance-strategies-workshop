package app.mappedsuperclass

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TagServiceTest extends Specification {

    @Autowired
    TagService tagService

    def setup() {
        saveTags()
    }

    def saveTags() {
        def tag = new Tag()
        tag.name = 'test tag'
        tagService.save()
    }

    def cleanup() {
        tagService.deleteAll()
    }

    def 'findAll'() {
        tagService.findAll().name == ['test tag']
    }
}
