package rgun.vktestapp.ui.extras;

/**
 * Created by rgun on 04.08.16.
 */
public interface BaseViewMvp<P> {

    /**
     * Устанвить презентер соответствующий вью
     * @param presenter
     */
    void setPresenter(P presenter);
}
