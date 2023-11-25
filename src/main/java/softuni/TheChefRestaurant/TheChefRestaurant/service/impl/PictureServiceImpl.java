package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.PictureRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.PictureService;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllUrls() {
        return pictureRepository.findAllUrls();
    }
}
