/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class Group {

    public static void notEmpty(ToggleGroup... grupoMenu) {
        for (ToggleGroup grupo : grupoMenu) {
            grupo.selectedToggleProperty().addListener(
                    (ObservableValue<? extends Toggle> obs, Toggle old, Toggle novo) -> {
                        if (grupo.getSelectedToggle() == null) {
                            grupo.selectToggle(old);
                        }
                    });
        }
    }
}
