package org.humingk.movie.dal.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

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

    // import lombok.data
    topLevelClass.addImportedType("lombok.Data");
    topLevelClass.addImportedType("lombok.NoArgsConstructor");
    topLevelClass.addImportedType("lombok.AllArgsConstructor");
    // @Data
    topLevelClass.addAnnotation("@Data");
    topLevelClass.addAnnotation("@NoArgsConstructor");
    topLevelClass.addAnnotation("@AllArgsConstructor");
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
}
