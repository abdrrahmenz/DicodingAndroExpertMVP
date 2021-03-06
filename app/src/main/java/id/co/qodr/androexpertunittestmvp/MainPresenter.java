package id.co.qodr.androexpertunittestmvp;

/**
 * Created by adul on 08/09/17.
 */

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public double volume(double panjang, double lebar, double tinggi){
        return panjang * lebar * tinggi;
    }

    public void hitungVolume(double panjang, double lebar, double tinggi){
        double volume = volume(panjang, lebar, tinggi);
        MainModel model = new MainModel(volume);
        view.tampilVolume(model);
    }
}
