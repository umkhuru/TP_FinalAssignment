package za.ac.cput.project.services;

import za.ac.cput.project.domain.Transportation;

import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
public interface CarListService {

    public List<Transportation> getLocal();
    public List<Transportation> getLuxery();
    public List<Transportation> getExotic();
}
