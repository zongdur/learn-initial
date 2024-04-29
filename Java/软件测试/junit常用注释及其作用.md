@Test  标明这是一个测试用例
@BeforeAll  
@AfterAll
@BeforeEach
@AfterEach


annotation   给.....做注解

测试中的参数化

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
规定了测试用例的执行过程

@ParameterizedTest        //测试参数化
@MethodSource("Generate")     //标出参数来源是一个方法


@Suite
@SelectPackages (value={"example"})
通过调用包来实现测试用例调用
