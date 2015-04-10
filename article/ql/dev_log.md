#QL项目日志

#####java.lang.ClassNotFoundException: org.springframework.ui.freemarker.FreeMarkerConfigurationFactory

在配置好FreeMarker和SpringMVC以后出现这个错误;

	java.lang.ClassNotFoundException: org.springframework.ui.freemarker.FreeMarkerConfigurationFactory
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1714)
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1559)
	at java.lang.ClassLoader.defineClassImpl(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:326)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:155)
	at org.apache.catalina.loader.WebappClassLoader.findClassInternal(WebappClassLoader.java:2895)
	at org.apache.catalina.loader.WebappClassLoader.findClass(WebappClassLoader.java:1173)
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1681)
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1559)
	at org.springframework.util.ClassUtils.forName(ClassUtils.java:255)
	at org.springframework.beans.factory.support.AbstractBeanDefinition.resolveBeanClass(AbstractBeanDefinition.java:416)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doResolveBeanClass(AbstractBeanFactory.java:1302)
	at org.springframework.beans.factory.support.AbstractBeanFactory.resolveBeanClass(AbstractBeanFactory.java:1273)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.predictBeanType(AbstractAutowireCapableBeanFactory.java:575)
	at org.springframework.beans.factory.support.AbstractBeanFactory.isFactoryBean(AbstractBeanFactory.java:1350)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doGetBeanNamesForType(DefaultListableBeanFactory.java:355)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:334)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:321)
	at org.springframework.context.support.AbstractApplicationContext.getBeanNamesForType(AbstractApplicationContext.java:1174)
	at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.initHandlerMethods(AbstractHandlerMethodMapping.java:102)
	at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.afterPropertiesSet(AbstractHandlerMethodMapping.java:88)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping.afterPropertiesSet(RequestMappingHandlerMapping.java:163)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1571)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1509)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:521)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:458)
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:296)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:223)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:293)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:194)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:628)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:932)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:479)
	at org.springframework.web.servlet.FrameworkServlet.configureAndRefreshWebApplicationContext(FrameworkServlet.java:651)
	at org.springframework.web.servlet.FrameworkServlet.createWebApplicationContext(FrameworkServlet.java:602)
	at org.springframework.web.servlet.FrameworkServlet.createWebApplicationContext(FrameworkServlet.java:665)
	at org.springframework.web.servlet.FrameworkServlet.initWebApplicationContext(FrameworkServlet.java:521)
	at org.springframework.web.servlet.FrameworkServlet.initServletBean(FrameworkServlet.java:462)
	at org.springframework.web.servlet.HttpServletBean.init(HttpServletBean.java:136)
	at javax.servlet.GenericServlet.init(GenericServlet.java:160)
	at org.apache.catalina.core.StandardWrapper.initServlet(StandardWrapper.java:1280)
	at org.apache.catalina.core.StandardWrapper.loadServlet(StandardWrapper.java:1193)
	at org.apache.catalina.core.StandardWrapper.load(StandardWrapper.java:1088)
	at org.apache.catalina.core.StandardContext.loadOnStartup(StandardContext.java:5176)
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5460)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
	at org.apache.catalina.core.StandardContext.reload(StandardContext.java:3954)
	at org.apache.catalina.loader.WebappLoader.backgroundProcess(WebappLoader.java:426)
	at org.apache.catalina.core.ContainerBase.backgroundProcess(ContainerBase.java:1345)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1530)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1540)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1540)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.run(ContainerBase.java:1519)
	at java.lang.Thread.run(Thread.java:795)

解决办法:

在Maven依赖里面添加下面的依赖:

	<dependency>
    	<groupId>org.springframework</groupId>
    	<artifactId>spring-context-support</artifactId>
    	<version>3.2.4.RELEASE</version>
	</dependency>