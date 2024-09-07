package com.spring.semana4_batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.spring.semana4_batch.entity.Car;
import com.spring.semana4_batch.repository.CarRepository;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {
	
	private JobBuilderFactory jobBuilderFactory;
	
	private StepBuilderFactory stepBuilderFactory;
	
	private CarRepository carrepository;
	
	@Bean
	public FlatFileItemReader<Car>reader()
	{
		FlatFileItemReader<Car>itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/MOCK_DATA.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}
	
	private LineMapper<Car>lineMapper(){
		DefaultLineMapper<Car> lineMapper=new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "car_make", "car_model", "car_year", "car_vin");
		
		BeanWrapperFieldSetMapper<Car> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Car.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		return lineMapper;
	}
	
	@Bean
	public CarProcessor processor()
	{
		return new CarProcessor();
	}
	
	public RepositoryItemWriter<Car> writer()
	{
		RepositoryItemWriter<Car> writer = new RepositoryItemWriter<>();
		writer.setRepository(carrepository);
		writer.setMethodName("save");
		return writer;
	}
	
	@Bean
	public Step step1()
	{
		return stepBuilderFactory.get("csv-step").<Car,Car>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Bean
	public Job runjob()
	{
		return jobBuilderFactory.get("importCar")
				.flow(step1()).end().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
