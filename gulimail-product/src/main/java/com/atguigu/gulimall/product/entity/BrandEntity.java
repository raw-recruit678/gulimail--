package com.atguigu.gulimall.product.entity;

import com.atguigu.common.vaild.AddGroup;
import com.atguigu.common.vaild.ListValue;
import com.atguigu.common.vaild.UpdateGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author lambda
 * @email lambda@gmail.com
 * @date 2022-01-15 13:24:23
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改时id不能为空", groups = {UpdateGroup.class})
	@Null(message = "新增时不能指定id", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名必须提交", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty(groups = {AddGroup.class})
	@URL(message = "logo必须是一个合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValue(vals = {0, 1}, groups = {AddGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups = {AddGroup.class, UpdateGroup.class})
	@Pattern(regexp = "/^[a-zA-Z]$/", message = "检索首字母必须是一个字母")
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = {AddGroup.class, UpdateGroup.class})
	@Min(value = 0, message = "排序必须大于等于0")
	private Integer sort;

}
