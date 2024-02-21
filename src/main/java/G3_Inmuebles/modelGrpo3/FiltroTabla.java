/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G3_Inmuebles.modelGrpo3;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;

public class FiltroTabla {
  public static void filtrar(JTable tabla, JComboBox<String> comboBoxDimension,
                               JComboBox<String> comboBoxNumHabitaciones,
                               JComboBox<String> comboBoxServicios,
                               JComboBox<String> comboBoxNormas) {
        String dimension = (String) comboBoxDimension.getSelectedItem();
        String numHabitaciones = (String) comboBoxNumHabitaciones.getSelectedItem();
        String servicios = (String) comboBoxServicios.getSelectedItem();
        String normas = (String) comboBoxNormas.getSelectedItem();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
        List<RowFilter<Object,Object>> filters = new ArrayList<>();

        if (!dimension.equals("Todo")) {
            filters.add(RowFilter.regexFilter(dimension, 1));
        }
        if (!numHabitaciones.equals("Todo")) {
            filters.add(RowFilter.regexFilter(numHabitaciones, 2));
        }
        if (!servicios.equals("Todo")) {
            filters.add(RowFilter.regexFilter(servicios, 3));
        }
        if (!normas.equals("Todo")) {
            filters.add(RowFilter.regexFilter(normas, 4));
        }

        sorter.setRowFilter(RowFilter.andFilter(filters));
        tabla.setRowSorter(sorter);
    }
}