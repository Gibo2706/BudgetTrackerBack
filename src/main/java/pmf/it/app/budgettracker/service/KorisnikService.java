package pmf.it.app.budgettracker.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import model.Korisnik;
import model.Token;
import pmf.it.app.budgettracker.dto.RegisterDTO;
import pmf.it.app.budgettracker.dto.ResponseDTO;
import pmf.it.app.budgettracker.repository.KorisnikRepo;

@Service
public class KorisnikService {
	@Autowired
	KorisnikRepo kr;
	
	@Autowired
	TokenService ts;
	
	@Transactional
	public ResponseDTO signUp(RegisterDTO regUser) {
		if(Objects.nonNull(kr.findByEmail(regUser.email())))
			throw new RuntimeException("Korisnik vec postoji");
		
		String encPass = regUser.password();
		try {
			encPass = hashPassword(encPass);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Korisnik k = new Korisnik();
		k.setEmail(regUser.email());
		k.setUsername(regUser.username());
		k.setPassword(encPass);
		k.setName(regUser.firstName());
		k.setLastname(regUser.lastName());
		k = kr.save(k);
		
		Token token = new Token();
		token.setKorisnik(k);
		token.setToken(UUID.randomUUID().toString());
		ts.saveConfirmationToken(token);
		
		return new ResponseDTO("Successfully", encPass);
	}

	private String hashPassword(String encPass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(encPass.getBytes());
		byte[] digest = md.digest();
		String hash =  DatatypeConverter.printHexBinary(digest).toUpperCase();
		return hash;
	}
}
