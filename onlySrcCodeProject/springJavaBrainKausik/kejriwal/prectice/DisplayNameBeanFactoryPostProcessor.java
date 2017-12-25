package kejriwal.prectice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DisplayNameBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactoryOrContext)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("BeanFactoryPostProcessor is called "+beanFactoryOrContext);
		
	}

}
