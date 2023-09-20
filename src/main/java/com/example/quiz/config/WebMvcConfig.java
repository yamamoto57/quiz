package com.example.quiz.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// ページネーションの設定を追加
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		// PageRequest.ofの第1引数はページ番号、第２引数は1ページ当たりの表示件数を指定
		resolver.setFallbackPageable(PageRequest.of(0, 5));
		resolvers.add(resolver);
	}
}
