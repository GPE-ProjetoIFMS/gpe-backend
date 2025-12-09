// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package com.br.gpe.security.controller;


// /**
//  *
//  * @author 1513003
//  */
// @RestController
// @RequiredArgsConstructor
// @RequestMapping("/api/auth") // Endpoint para autenticação local
// public class AuthenticationController {

//     private final AuthService authService;

//     @PostMapping("/register")
//     public String registerUser(
//             @RequestBody UsuarioRegisterRequest user
//     ) {
//         return authService.register(user);
//     }

//     /**
//      * Endpoint para autenticação local (usuário/senha) e emissão de JWT.
//      *
//      * @param loginRequest
//      * @return
//      */
//     @PostMapping("/token")
//     public ResponseEntity<AuthResponse> authenticate(
//             @RequestBody @Valid LoginRequest loginRequest) {

//         // 1. Delega a autenticação e a geração do token para o Service
//         // O AuthService lida com AuthenticationManager.authenticate() e JwtEncoder.encode()
//         String jwtToken = authService.getToken(loginRequest);

//         // 2. Retorna o token para o cliente
//         // Você pode obter o tempo de expiração do JWT, mas aqui é um valor fixo
//         AuthResponse response = new AuthResponse(
//                 jwtToken,
//                 "Bearer",
//                 3600L // Exemplo: 1 hora
//         );

//         return ResponseEntity.ok(response);
//     }

//     @PostMapping("/login")
//     public String loginUser(
//             @RequestBody LoginRequest authenticationRequest
//     ) throws Exception {
//         return authService.getToken(authenticationRequest);
//     }

//     @PostMapping("/logout")
//     public ResponseEntity<Void> logout(HttpServletRequest request) {
//         // 1. Extrai o token do cabeçalho Authorization
//         String authorizationHeader = request.getHeader("Authorization");
//         if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//             String token = authorizationHeader.substring(7);
//             authService.logout(token);
//         }
//         // 2. O cliente é instruído a descartar o token
//         return ResponseEntity.ok().build();
//     }

//     @PutMapping("/password/change")
//     public ResponseEntity<Void> changePassword(
//             @RequestBody @Valid ChangePasswordRequest request,
//             Principal principal // Spring Security injeta o usuário autenticado aqui
//     ) {
//         // O nome de usuário é obtido do JWT (sujeito/sub)
//         String username = principal.getName();

//         authService.changePassword(
//                 username,
//                 request.oldPassword(),
//                 request.newPassword()
//         );
//         return ResponseEntity.ok().build();
//     }

//     // Endpoint de Acesso Público
//     @PostMapping("/password/forgot")
//     public ResponseEntity<Void> forgotPassword(
//             @RequestBody @Valid ForgotPasswordRequest request) {

//     //     authService.createPasswordResetToken(request.emailOrUsername());

//     //     // Retorna 200 OK em todos os casos por segurança
//     //     return ResponseEntity.ok().build();
//     // }

//     // Endpoint de Acesso Público
//     @PostMapping("/password/reset")
//     public ResponseEntity<Void> resetPassword(
//             @RequestBody @Valid ResetPasswordRequest request) {

//         authService.resetPassword(request.token(), request.newPassword());
//         return ResponseEntity.ok().build();
//     }
// }
