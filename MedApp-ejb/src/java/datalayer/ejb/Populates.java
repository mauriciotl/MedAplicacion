package datalayer.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.enums.EstudioType;
import model.entities.enums.MediaType;
import model.entities.other.EstudioMed;
import model.entities.other.Expediente;
import model.entities.other.Interpretacion;
import model.entities.other.MediaFile;
import model.entities.other.ServLab;
import model.entities.usuario.*;

@Singleton
@Startup
public class Populates {
    
    
// ===================================== 
// = Attributes  = 
// ===================================== 

    @PersistenceContext
    private EntityManager em;
    

// ===================================== 
// = Methods  = 
// ===================================== 

    @PostConstruct
    public void inicial(){
        
//        System.out.println("MTL: about to persist usuarios.");
//        //1. Persiste Usuarios
//        for(Usuario u: creaUsuarios()){
//            em.persist(u);
//        }
//        
//        System.out.println("MTL: about to persist expedientes.");
//        //2. Persiste Expedientes
//        for(Expediente e: creaExpedientes()){
//            em.persist(e);
//        }
        
        
        
        
        System.out.println("Crea un servicio completo de laboratorio");
        //3. Crea un servicio completo  ============================================================
        
        
        
         //1. Se crean los usuarios necesarios
        
         
        String nombre = "Omar",
                email = "Omar@mail",
                password = "Omar",
                telefono = "999-333-23";
        Paciente paciente = new Paciente(nombre, email, password, telefono);
        
        String  nombre_2 = "Male",
                email_2 = "Male@mail",
                password_2 = "Male",
                codigo = "K34Male";
        Recepcionista recep = new Recepcionista(nombre_2, email_2, password_2, codigo);
        
        String  nombre_3 = "Ana",
                email_3 = "Ana@mail",
                password_3 = "Ana",
                registro = "Ana-777";
        Tecnico tecnico = new Tecnico(nombre_3, email_3, password_3, registro);
        
        String  nombre_4 = "martha",
                email_4 = "martha@mail",
                password_4 = "martha",
                cedula = "asd23";
        Medico medico = new Medico(nombre_4, email_4, password_4, cedula);
        
        String nombre_5 = "Gerardo",
                email_5 = "Gerardo@mail",
                password_5 = "Gerardo",
                Tipo = "root";
        Administrador administrador = new Administrador(nombre_5, email_5, password_5, Tipo);
        
        
        //2. Se crea Expediente
        Expediente expediente = new Expediente("28-08-2017", paciente);
        
        
        //2.1 Se crea Lista de Expediente y se asigna a Administrador
        List<Expediente> expedientes = new ArrayList<>();
        expedientes.add(expediente);
        
        administrador.setExpediente(expedientes);
        
        
        //3. Se crean ServLab 1..n y se agrega a expediente
        ServLab sl = new ServLab("28-08-2017", "Servicio de laboratorio urgente", recep);
        List<ServLab> serviciosLab = new ArrayList<>();
        serviciosLab.add(sl);
        
        expediente.setServicioLaboratorios(serviciosLab);
        
        
        //4. Se crean EstudioMed 1..n y se agregan a ServLab
        
        EstudioMed estudioMed = new EstudioMed(EstudioType.RADIOLOGIA, 1200, "28-08-2017", tecnico);
        List<EstudioMed> estudiosMedicos = new ArrayList<>();
        estudiosMedicos.add(estudioMed);
        
        sl.setEstudiosMedicos(estudiosMedicos);
        
        
        //4.1. Se le adicionan algunos mediaFiles al EstudioMed
        
        MediaFile mediaFile = new MediaFile("Radiografía del torax", MediaType.IMAGEN, new byte[200]);
        MediaFile mediaFile_2 = new MediaFile("Toma de corazón", MediaType.AUDIO, new byte[100]);
        MediaFile mediaFile_3 = new MediaFile("Toma desde ultrasonido", MediaType.VIDEO, new byte[100]);
        
        List<MediaFile> mediaFiles = new ArrayList<>();
        
        mediaFiles.add(mediaFile);
        mediaFiles.add(mediaFile_2);
        mediaFiles.add(mediaFile_3);
        
        
        //5. Se agregan MediaFiles al EstudioMedico
        estudioMed.setMediaFiles(mediaFiles);
        
        
        //6. Se crea una Interpretacion y se agrega el estudioMedico
        
        Interpretacion interpret = new Interpretacion("28-08-2017", 
                "Se trata de un desgaste por descalsificación grado d23, normal", medico);
        
        estudioMed.setInterpretacion(interpret);
        interpret.setIsComplete(true);
       
        //Se ha completado el proceso completo
        
        estudioMed.setIsComplete(true);
        sl.setIsComplete(true);
        
        //Se realiza la persistencia
        
        System.out.println("Va ha realizar la persistencia del expediente");
        em.persist(administrador);
        
        
        
        
        
        
    }
    
// ===================================== 
// = Helper methods  = 
// ===================================== 

    
    private static List<Usuario> creaUsuarios(){
        
        List<Usuario> usuarios = new ArrayList<>();
        
        //Se crearán diferentes usuarios
        
        String  nombre = "Lalo",
                email = "lalo@mail",
                password = "lalo",
                tipo = "A";
        Administrador admin = new Administrador(nombre, email, password, tipo);
        usuarios.add(admin);
       
        String  nombre_2 = "martha",
                email_2 = "martha@mail",
                password_2 = "martha",
                cedula = "asd23";
        Medico medico = new Medico(nombre_2, email_2, password_2, cedula);
        usuarios.add(medico);
        
        String  nombre_3 = "jorge",
                email_3 = "jorge@mail",
                password_3 = "jorge",
                telefono = "5464-454-45";
        Paciente paciente = new Paciente(nombre_3, email_3, password_3, telefono);
        usuarios.add(paciente);
        
        String  nombre_4 = "sandy",
                email_4 = "sandy@mail",
                password_4 = "sandy",
                codigo = "K34";
        Recepcionista recep = new Recepcionista(nombre_4, email_4, password_4, codigo);
        usuarios.add(recep);
        
        
        String  nombre_5 = "albert",
                email_5 = "albert@mail",
                password_5 = "albert",
                registro = "NM56";
        Tecnico tecnico = new Tecnico(nombre_5, email_5, password_5, registro);
        usuarios.add(tecnico);
        
        return usuarios;
        
    }
    
    
    private static List<Expediente> creaExpedientes(){
        
        List<Expediente> expedientes = new ArrayList<>();
        
        String  nombre = "Karo",
                email = "Karo@mail",
                password = "Karo",
                telefono = "888-777-45";
        Paciente paciente = new Paciente(nombre, email, password, telefono);
        Expediente expediente = new Expediente("27-08-2017", paciente);
        expedientes.add(expediente);
        
        String  nombre_2 = "Omar",
                email_2 = "Omar@mail",
                password_2 = "Omar",
                telefono_2 = "999-333-23";
        Paciente paciente_2 = new Paciente(nombre_2, email_2, password_2, telefono_2);
        Expediente expediente_2 = new Expediente("27-08-2017", paciente_2);
        expedientes.add(expediente_2);
        
        
        return expedientes;
    }
    
    
    private static void creaServicioCompletoLaboratorio(){
        
        //1. Se crean los usuarios necesarios
         
        String nombre = "Omar",
                email = "Omar@mail",
                password = "Omar",
                telefono = "999-333-23";
        Paciente paciente = new Paciente(nombre, email, password, telefono);
        
        String  nombre_2 = "Male",
                email_2 = "Male@mail",
                password_2 = "Male",
                codigo = "K34Male";
        Recepcionista recep = new Recepcionista(nombre_2, email_2, password_2, codigo);
        
        String  nombre_3 = "Ana",
                email_3 = "Ana@mail",
                password_3 = "Ana",
                registro = "Ana-777";
        
        Tecnico tecnico = new Tecnico(nombre_3, email_3, password_3, registro);
        
        String  nombre_4 = "martha",
                email_4 = "martha@mail",
                password_4 = "martha",
                cedula = "asd23";
        Medico medico = new Medico(nombre_4, email_4, password_4, cedula);
        
        
        //2. Se crea Expediente
        Expediente expediente = new Expediente("28-08-2017", paciente);
        
        
        //3. Se crean ServLab 1..n y se agrega a expediente
        ServLab sl = new ServLab("28-08-2017", "Servicio de laboratorio urgente", recep);
        
        List<ServLab> serviciosLab = new ArrayList<>();
         
        expediente.setServicioLaboratorios(serviciosLab);
        
        
        //4. Se crean EstudioMed 1..n y se agregan a ServLab
        
        EstudioMed estudioMed = new EstudioMed(EstudioType.RADIOLOGIA, 1200, "28-08-2017", tecnico);
        List<EstudioMed> estudiosMedicos = new ArrayList<>();
        estudiosMedicos.add(estudioMed);
        
        sl.setEstudiosMedicos(estudiosMedicos);
        
        
        //4.1. Se le adicionan algunos mediaFiles al EstudioMed
        
        MediaFile mediaFile = new MediaFile("Radiografía del torax", MediaType.IMAGEN, new byte[200]);
        MediaFile mediaFile_2 = new MediaFile("Toma de corazón", MediaType.AUDIO, new byte[100]);
        MediaFile mediaFile_3 = new MediaFile("Toma desde ultrasonido", MediaType.VIDEO, new byte[100]);
        
        List<MediaFile> mediaFiles = new ArrayList<>();
        
        mediaFiles.add(mediaFile);
        mediaFiles.add(mediaFile_2);
        mediaFiles.add(mediaFile_3);
        
        
        //5. Se agregan MediaFiles al EstudioMedico
        estudioMed.setMediaFiles(mediaFiles);
        
        
        //6. Se crea una Interpretacion y se agrega el estudioMedico
        
        Interpretacion interpret = new Interpretacion("28-08-2017", 
                "Se trata de un desgaste por descalsificación grado d23, normal", medico);
        
        estudioMed.setInterpretacion(interpret);
        interpret.setIsComplete(true);
       
        //Se ha completado el proceso completo
        
        estudioMed.setIsComplete(true);
        sl.setIsComplete(true);
        
        
        //Se realiza la persistencia
        
        
        
    }
    
    
    
}
