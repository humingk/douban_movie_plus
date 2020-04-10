package org.humingk.movie.dal.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

;

/**
 * Mybatis 插件，自定义注释+lombak
 *
 * @author humingk
 */
public class MyBatisPlugin extends PluginAdapter {
  @Override
  public boolean validate(List<String> list) {
    return true;
  }

  /**
   * 类注释
   *
   * @param topLevelClass
   * @param introspectedTable
   * @return
   */
  @Override
  public boolean modelBaseRecordClassGenerated(
      TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    topLevelClass.addJavaDocLine("/**");
    String remarks = introspectedTable.getRemarks();
    topLevelClass.addJavaDocLine(" * " + remarks);
    topLevelClass.addJavaDocLine(" *");
    topLevelClass.addJavaDocLine(" *@author humingk");
    topLevelClass.addJavaDocLine(" */");
    addLombok(topLevelClass);
    topLevelClass.addImportedType("lombok.NoArgsConstructor");
    topLevelClass.addAnnotation("@NoArgsConstructor");
    return true;
  }

  /**
   * 方法注释
   *
   * @param field
   * @param topLevelClass
   * @param introspectedColumn
   * @param introspectedTable
   * @param modelClassType
   * @return
   */
  @Override
  public boolean modelFieldGenerated(
      Field field,
      TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn,
      IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {
    field.addJavaDocLine("/**");
    String remarks = introspectedColumn.getRemarks();
    field.addJavaDocLine(" * " + remarks);
    field.addJavaDocLine(" */");
    return true;
  }

  /**
   * 禁止setter
   *
   * @param method
   * @param topLevelClass
   * @param introspectedColumn
   * @param introspectedTable
   * @param modelClassType
   * @return
   */
  @Override
  public boolean modelSetterMethodGenerated(
      Method method,
      TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn,
      IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {
    return false;
  }

  /**
   * 禁止getter
   *
   * @param method
   * @param topLevelClass
   * @param introspectedColumn
   * @param introspectedTable
   * @param modelClassType
   * @return
   */
  @Override
  public boolean modelGetterMethodGenerated(
      Method method,
      TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn,
      IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {
    return false;
  }

  /**
   * 将Example注册为bean,另外再增加一个start()方法，调用之前clear一下
   *
   * <p>Example使用方式：先用@Autowired引入，再用example.start().xxx
   *
   * @param topLevelClass
   * @param introspectedTable
   * @return
   */
  @Override
  public boolean modelExampleClassGenerated(
      TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    Method method = new Method();
    method.setVisibility(JavaVisibility.PUBLIC);
    method.setReturnType(new FullyQualifiedJavaType("Criteria"));
    method.setName("start");
    method.addBodyLine("oredCriteria = new ArrayList<>();");
    method.addBodyLine("clear();");
    method.addBodyLine("return createCriteria();");
    topLevelClass.addMethod(method);
    // 注册为bean
    topLevelClass.addImportedType("org.springframework.stereotype.Repository");
    topLevelClass.addAnnotation("@Repository");
    addLombok(topLevelClass);
    topLevelClass.addJavaDocLine("/** @author humingk */");
    return true;
  }

  /**
   * 增加lombok插件
   *
   * @param topLevelClass
   */
  public void addLombok(TopLevelClass topLevelClass) {
    topLevelClass.addImportedType("lombok.Data");
    topLevelClass.addImportedType("lombok.AllArgsConstructor");
    topLevelClass.addAnnotation("@Data");
    topLevelClass.addAnnotation("@AllArgsConstructor");
  }
}
