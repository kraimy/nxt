package com.exam.nxt;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
@SuppressWarnings("all")
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/nxt?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("kremi") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\kyy34\\Desktop\\nxt\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.exam.nxt") // 设置父包名
                            //.moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\Users\\kyy34\\Desktop\\nxt\\src\\main\\resources\\mapping")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user","cart","category","orderitem","orders","payinfo","product","shopping","address","collection","comments") // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_", "sys_")// 设置过滤表前缀
                            .entityBuilder().enableLombok();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
