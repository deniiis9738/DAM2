package biblio
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()
    val t = sessio.beginTransaction()
    val e = Editorial("ed5","Tabarca Llibres","www.tabarcallibres.com", mutableSetOf<Llibre>())
    val ll = Llibre("8480241815","L'ull de la boira",141,e)
    e.llibres.add(ll)
    sessio.persist(e)
    sessio.persist(ll)
    t.commit()
    sessio.close()
}