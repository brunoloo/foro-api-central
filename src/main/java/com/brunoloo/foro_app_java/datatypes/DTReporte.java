package com.brunoloo.foro_app_java.datatypes;

import com.brunoloo.foro_app_java.datatypes.enumeration.EMotivoReporte;

public class DTReporte {
    private EMotivoReporte motivo;
    private TFecha fechaReporte;


    public DTReporte(){} // constructor vacío

    public DTReporte(EMotivoReporte motivo, TFecha fechaReporte) { // constructor con parámetros
        this.motivo = motivo;
        this.fechaReporte = fechaReporte;
    }

}
