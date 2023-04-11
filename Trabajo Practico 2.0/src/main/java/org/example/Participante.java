package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Participante {

    private int id;
    private String nombre;
    private List<Pronostico> pronostico;

}
