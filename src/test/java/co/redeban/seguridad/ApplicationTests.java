package co.redeban.seguridad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pe.bbva.tipocambio.business.core.dto.RequestTipoCambioDto;

@SpringBootTest(classes = RequestTipoCambioDto.class)

@EnableTransactionManagement
//@EntityScan("pe.bbva.tipocambio.dao.*")
//@EnableJpaRepositories("pe.bbva.tipocambio.dao.*")
//
//@ComponentScan({ "pe.bbva.*" })
class ApplicationTests {

//	private RolService rolService;

	public ApplicationTests() {
//		rolService = new RolServiceImpl();
	}

    @Test                                               
    public void testconsultarRoles3() {
        assertEquals(11, 5+6,    "Regular multiplication should work");          
    }

}
