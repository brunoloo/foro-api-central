package com.brunoloo.foro_app_java.datatypes;

import com.brunoloo.foro_app_java.datatypes.enumeration.MotivoReporte;

public class DTReporte {
    private MotivoReporte motivo;
    private TFecha fechaReporte;


    public DTReporte(){} // constructor vacío

    public DTReporte(MotivoReporte motivo, TFecha fechaReporte) { // constructor con parámetros
        this.motivo = motivo;
        this.fechaReporte = fechaReporte;
    }

}
