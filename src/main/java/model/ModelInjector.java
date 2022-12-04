package model;

import lombok.Getter;
import model.external.SimpsonsModule;

public class ModelInjector {

    private static ModelInjector instance;

    @Getter Model model = new ModelImpl(SimpsonsModule.getInstance().getSimpsonsService());

    private ModelInjector() {}

    public static ModelInjector getInstance() {
        if (instance == null) {
            instance = new ModelInjector();
        }
        return instance;
    }

}
