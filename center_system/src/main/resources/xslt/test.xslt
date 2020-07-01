<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<学生选课信息>
	<课程编号><xsl:value-of select="课程编号A"/></课程编号>
	<学生信息>
		<学生账号><xsl:value-of select="A系统学生选课信息/学生信息A/学生账号A"/></学生账号>
		<学生密码><xsl:value-of select="A系统学生选课信息/学生信息A/学生密码A"/></学生密码>
		<创建日期><xsl:value-of select="A系统学生选课信息/学生信息A/创建日期A"/></创建日期>
		<学生编号><xsl:value-of select="A系统学生选课信息/学生信息A/学生编号A"/></学生编号>
		<学生姓名><xsl:value-of select="A系统学生选课信息/学生信息A/学生姓名A"/></学生姓名>
		<学生性别><xsl:value-of select="A系统学生选课信息/学生信息A/学生性别A"/></学生性别>
	</学生信息>
	<学生成绩A><xsl:value-of select="A系统学生选课信息/学生成绩A"/></学生成绩A>
</学生选课信息>
</xsl:template>

</xsl:stylesheet>