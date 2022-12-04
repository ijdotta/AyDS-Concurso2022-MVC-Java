package view;

import lombok.Getter;

public class ViewInjector {
    private static ViewInjector instance;

    @Getter
    private final View view = new ViewImpl(new UiComponentsImpl());

    public static ViewInjector getInstance() {
        if (instance == null) {
            instance = new ViewInjector();
        }
        return instance;
    }
}
