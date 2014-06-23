package model;

public class userTest {
    /*user testUser;
    user testUser2;
    @Before
    public void setUp() throws Exception {
        if(Ebean.find(user.class, "testUser@sample.com") == null) {
            testUser = new user();
            testUser.setEmail("testUser@sample.com");
            testUser.setName("Test Vladof");
            testUser.setPassword("secret");
            testUser.setU_role(user.szKor.valueOf("ADMINISZTRATOR"));
            Ebean.save(testUser);
        }
    }

    @Test
    public void transactionTest() throws Exception {
        testUser2 = Ebean.find(user.class, "maxime@sample.com");
        Assert.assertEquals("maxime@sample.com", testUser2.getEmail());
        Assert.assertEquals("secret", testUser2.getPassword());
    }

    @Test
    public void testAuthUser() throws Exception {
        authCtrl ctrl = new authCtrl();
        testUser2 = Ebean.find(user.class, "maxime@sample.com");
        Assert.assertEquals(testUser2 , (user)Ebean.find(user.class).where().eq("email", "maxime@sample.com").eq("password", "secret").findUnique());

        //delete testuser
        Ebean.delete(user.class, "testUser@sample.com");
        Assert.assertNull(Ebean.find(user.class, "testUser@sample.com"));
    }
*/
    /*@Test
    public void testAuth() throws Exception {
        AuthCtrl auth = new AuthCtrl();
        Session currentSess = auth.loginUser("maxime@sample.com", "secret");
        Assert.assertEquals("Maxime Dantec", currentSess.getCurrentUser().getName());
    }*/
}