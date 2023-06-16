package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.DTO.JwtResponse;
import com.gympower.web.DTO.JwtRequest;
import com.gympower.web.security.JwtUtil;
import com.gympower.web.services.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class AuthController {
    @Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	 @Autowired
	    private JwtUtil jwtUtil;
	 
	 @PostMapping("/")
	    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		 try {
			 autenticar(jwtRequest.getCorreo(),jwtRequest.getPassword());
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
	            throw new Exception("Usuario no encontrado");
		}
		 
		 UserDetails userDetails =  this.userDetailsServiceImpl.loadUserByUsername("" + jwtRequest.getCorreo());
		 String token = this.jwtUtil.generateToken(userDetails);
		 return ResponseEntity.ok(new JwtResponse(token));
	 }
	 
	 private void autenticar(String correo,String password) throws Exception {
	        try{
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(correo,password));
	        }catch (DisabledException exception){
	            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
	        }catch (BadCredentialsException e){
	            throw  new Exception("Credenciales invalidas " + e.getMessage());
	        }
	    }
}
