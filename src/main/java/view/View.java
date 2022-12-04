package view;

import common.observer.Observable;

public interface View {
    Observable<UiEvent> getUiEventObservable();
    UiState getUiState();
    void openView();
}
