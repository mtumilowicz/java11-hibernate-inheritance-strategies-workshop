package app.singletable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ShapeService {

    @Autowired
    CircleRepository circleRepository;

    @Autowired
    RectangleRepository rectangleRepository;

    @Autowired
    ShapeRepository shapeRepository;

    Shape save(Shape shape) {
        return shapeRepository.save(shape);
    }

    List<Circle> findAllCircles() {
        return circleRepository.findAll();
    }

    List<Rectangle> findAllRectangles() {
        return rectangleRepository.findAll();
    }

    List<Shape> findAll() {
        return shapeRepository.findAll();
    }

    void deleteAll() {
        shapeRepository.deleteAll();
    }
}