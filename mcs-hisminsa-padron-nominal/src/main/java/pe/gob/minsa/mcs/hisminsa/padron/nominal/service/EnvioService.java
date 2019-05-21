package pe.gob.minsa.mcs.hisminsa.padron.nominal.service;

import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaEntity;

public interface EnvioService {
    public String ActualizaIpress();
    public String ActualizaIpressProperties(ActualizaEntity request);
}
