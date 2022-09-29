package com.example.ll.batch_app.job.helloworld;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob(Step helloWorldStep1){
        return jobBuilderFactory.get("helloWorldJob")
                .incrementer(new RunIdIncrementer()) //강제로 매번 다른 ID를 실행시에 파라미터로 부여
                .start(helloWorldStep1())
                .next(helloWorldStep2())
                .build();
    }
    @Bean
    @JobScope
    public Step helloWorldStep1(){
        return stepBuilderFactory.get("helloWorldStep1")
                .tasklet(helloWorldStep1Tasklet())
                .build();
    }
    //잡, 여러가지의 스텝들로 구성


    //작업단위 TaskletStep
    @Bean
    @StepScope
    public Tasklet helloWorldStep1Tasklet(){
        return new Tasklet(){
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("헬로월드 테스클릿 1");
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    @JobScope
    public Step helloWorldStep2(){
        return stepBuilderFactory.get("helloWorldStep2")
                .tasklet(helloWorldStep2Tasklet())
                .build();
    }
    //잡, 여러가지의 스텝들로 구성


    //작업단위 TaskletStep
    @Bean
    @StepScope
    public Tasklet helloWorldStep2Tasklet(){
        return new Tasklet(){
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("헬로월드 테스클릿 2");
                return RepeatStatus.FINISHED;
            }
        };
    }
}
