package com.demo.chess.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
//public class User implements UserDetails {
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(nullable = false)
    private String creatorIp;

    @Column(nullable = false)
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private LocalDateTime lastLogin;

    @Column(nullable = false, columnDefinition = "DECIMAL(13, 4)")
    private BigDecimal casualRating;

    @Column(nullable = false, columnDefinition = "DECIMAL(13, 4)")
    private BigDecimal rankedRating; //= BigDecimal.ZERO;

    @Column(nullable = false)
    private short badScore;

    @OneToMany(mappedBy = "host")
    private List<Lobby> lobbies;

    @OneToMany(mappedBy = "whiteRating")
    private List<Game> whiteGames;

    @OneToMany(mappedBy = "blackRating")
    private List<Game> blackGames;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(role);
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return nickname;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
