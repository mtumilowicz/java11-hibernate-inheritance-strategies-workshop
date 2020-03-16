package app.singletable

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ShapeServiceTest extends Specification {

    @Autowired
    ShapeService shapeService

    def setup() {
        saveCircles()
        saveRectangles()
    }

    def saveCircles() {
        def circle = new Circle()
        circle.radius = 15
        shapeService.save(circle)
    }

    def saveRectangles() {
        def rectangle = new Rectangle()
        rectangle.length = 10
        rectangle.width = 25
        shapeService.save(rectangle)
    }

    def cleanup() {
        shapeService.deleteAll()
    }

    def 'findAllCircles'() {
        expect:
        shapeService.findAllCircles().radius == [15]
    }

    def 'findAllRectangles'() {
        given:
        def rectangles = shapeService.findAllRectangles()

        expect:
        rectangles.length == [10]
        rectangles.width == [25]
    }

    def 'findAll'() {
        expect:
        shapeService.findAll().size() == 2
    }
}
