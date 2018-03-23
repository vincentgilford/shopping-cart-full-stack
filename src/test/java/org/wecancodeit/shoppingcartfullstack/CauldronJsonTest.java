package org.wecancodeit.shoppingcartfullstack;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class CauldronJsonTest {
	
	@Resource
	private JacksonTester<Potion> potionJson; 
	
	@Test
	public void shouldSerialize() throws IOException {
		Potion potion = new Potion("Health");
		
		JsonContent<Potion> content = potionJson.write(potion); 

		Assertions.assertThat(content).extractingJsonPathValue("@.itemName").isEqualTo("Health");
		
	}
	
	@Test
    public void shouldDeserialize() throws IOException {
        String jsonContent = "{\"itemName\": \"Health\" }";
        
        Potion parsed = potionJson.parseObject(jsonContent);
        
        Assertions.assertThat(parsed.getItemName()).isEqualTo("Health");
    }
	
	
	
	
	
}
