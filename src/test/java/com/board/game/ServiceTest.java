//package com.board.game;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ServiceTest {
//
//    @Test
//    public void shouldHaveFiveMillestonesAndTwoAwardsAndReturnInvalid() {
//        // given - dado
//        List<Player> players = new ArrayList<Player>();
//
//        Player player = new Player();
//        player.setMarcos(1);
//        player.setPremiosPrimeiro(1);
//
//        Player player2 = new Player();
//        player2.setMarcos(4);
//        player.setPremiosPrimeiro(1);
//
//        players.add(player);
//        players.add(player2);
//
//        // when - quando
//        Service service = new Service();
//        Boolean millestonesQuantity = service.validateMillestonesAndAwards(players);
//
//        // then - então
//        assertEquals(false, millestonesQuantity, "Inválido");
//
//        /*
//        if (millestonesQuantity > 3 || millestonesQuantity < 0) {
//            throw new RuntimeException("Marcos inválidos");
//        } else {
//            System.out.println("Marcos válidos");
//        } */
//    }
//
//    @Test
//    public void shouldHaveTwoMillestonesAndFourAwardsAndReturnInvalid() {
//        // given - dado
//        List<Player> players = new ArrayList<Player>();
//
//        Player player = new Player();
//        player.setMarcos(1);
//        player.setPremiosPrimeiro(2);
//
//        Player player2 = new Player();
//        player2.setMarcos(1);
//        player2.setPremiosPrimeiro(2);
//
//        players.add(player);
//        players.add(player2);
//
//        // when - quando
//        Service service = new Service();
//        Boolean millestonesQuantity = service.validateMillestonesAndAwards(players);
//
//        // then - então
//        assertEquals(false, millestonesQuantity, "Inválido");
//    }
//
//    @Test
//    public void shouldHaveFourMillestonesAndFourAwardsAndReturnInvalid() {
//        // given - dado
//        List<Player> players = new ArrayList<Player>();
//
//        Player player = new Player();
//        player.setMarcos(2);
//        player.setPremiosPrimeiro(2);
//
//        Player player2 = new Player();
//        player2.setMarcos(2);
//        player2.setPremiosPrimeiro(2);
//
//        players.add(player);
//        players.add(player2);
//
//        // when - quando
//        Service service = new Service();
//        Boolean millestonesQuantity = service.validateMillestonesAndAwards(players);
//
//        // then - então
//        assertEquals(false, millestonesQuantity, "Inválido");
//    }
//
//    @Test
//    public void shouldHaveTwoMillestonesAndOneAwardsAndReturnValid() {
//        // given - dado
//        List<Player> players = new ArrayList<Player>();
//
//        Player player = new Player();
//        player.setMarcos(1);
//        player.setPremiosPrimeiro(1);
//
//        Player player2 = new Player();
//        player2.setMarcos(0);
//        player2.setPremiosPrimeiro(1);
//
//        players.add(player);
//        players.add(player2);
//
//        // when - quando
//        Service service = new Service();
//        Boolean millestonesQuantity = service.validateMillestonesAndAwards(players);
//
//        // then - então
//        assertEquals(true, millestonesQuantity, "Inválido");
//    }
//
//    @Test
//    public void shouldHaveThreeMillestonesAndThreeAwardsAndReturnValid() {
//        // given - dado
//        List<Player> players = new ArrayList<Player>();
//
//        Player player = new Player();
//        player.setMarcos(1);
//        player.setPremiosPrimeiro(1);
//
//        Player player2 = new Player();
//        player2.setMarcos(2);
//        player2.setPremiosPrimeiro(2);
//
//        players.add(player);
//        players.add(player2);
//
//        // when - quando
//        Service service = new Service();
//        Boolean millestonesQuantity = service.validateMillestonesAndAwards(players);
//
//        // then - então
//        assertEquals(true, millestonesQuantity, "Inválido");
//    }
//
//}
