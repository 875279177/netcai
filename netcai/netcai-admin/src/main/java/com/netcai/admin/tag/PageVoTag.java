package com.netcai.admin.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.netcai.admin.utils.PageUtil;

/**
 * pageVo的自定义标签类
 * @author administrator
 */
public class PageVoTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private PageUtil pageVo;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = this.pageContext.getOut();
            if(pageVo == null) {
                return SKIP_BODY;
            }
            if (pageVo.getTotalPage() > 0) {
            	out.println("<li><a href=\"javascript:onSelectPage("+(0)+","+pageVo.getPageRecord()+")\">首页</a></li>");
                out.println("<li><a href=\"javascript:onSelectPage("+(pageVo.getCurrentPage()-1)+","+pageVo.getPageRecord()+")\">上一页</a></li>");
                if (pageVo.getTotalPage() <= 10) 
                {
                    for (int i = 1; i <= pageVo.getTotalPage(); i++) {
                        if (i == pageVo.getCurrentPage()) {
                            out.println("<li class=\"active\"><a href=\"javascript:onSelectPage("+i+","+pageVo.getPageRecord()+")\">"+i+"</a></li>");
                        } else {
                            out.println("<li><a href=\"javascript:onSelectPage("+i+","+pageVo.getPageRecord()+")\">"+i+"</a></li>");
                        }
                    }
                }

                if (pageVo.getTotalPage() > 10) {
                    if (pageVo.getCurrentPage() < 10) {
                        for (int i = 1; i <= 10; i++) {
                            if (i == pageVo.getCurrentPage()) {
                                out.println("<li class=\"active\"><a href=\"javascript:onSelectPage("+i+","+pageVo.getPageRecord()+")\">"+i+"</a></li>");
                            } else {
                                out.println("<li><a href=\"javascript:onSelectPage("+i+","+pageVo.getPageRecord()+")\">"+i+"</a></li>");
                            }
                        }
                    }
                    if (pageVo.getCurrentPage() >= 10) {
                        for (int j = pageVo.getCurrentPage()-5;j <= pageVo.getCurrentPage()+4; j++) {
                            if (j <= pageVo.getTotalPage()) {
                                if (j == pageVo.getCurrentPage()){
                                    out.println("<li class=\"active\"><a href=\"javascript:onSelectPage("+j+","+pageVo.getPageRecord()+")\">"+j+"</a></li>");
                                } else {
                                    out.println("<li><a href=\"javascript:onSelectPage("+j+","+pageVo.getPageRecord()+")\">"+j+"</a></li>");
                                }
                            }
                        }
                    }
                }
                
                if(pageVo.getCurrentPage()+1>=pageVo.getTotalPage())
                {
                	out.println("<li class=\"disabled\"><a href=\"javascript:void(0);\">下一页</a></li>");
                }else
                {
                	out.println("<li><a href=\"javascript:onSelectPage("+(pageVo.getCurrentPage()+1)+","+pageVo.getPageRecord()+")\">下一页</a></li>");
                }
                out.println("<li><a href=\"javascript:onSelectPage("+(pageVo.getTotalPage())+","+pageVo.getPageRecord()+")\">尾页</a></li>");
                out.println("<li>每页显示<select onchange=\"onSelectPage("+(pageVo.getCurrentPage())+",this.value)\">");
                if(pageVo.getPageRecord()==10){
                	out.println("<option value='10' selected>10</option>");
                }else{
                	out.println("<option value='10'>10</option>");
                }
                if(pageVo.getPageRecord()==20){
                	out.println("<option value='20' selected>20</option>");
                }else{
                	out.println("<option value='20'>20</option>");
                }
                if(pageVo.getPageRecord()==30){
                	out.println("<option value='30' selected>30</option>");
                }else{
                	out.println("<option value='30'>30</option>");
                }
                if(pageVo.getPageRecord()==50){
                	out.println("<option value='50' selected>50</option>");
                }else{
                	out.println("<option value='50'>50</option>");
                }
                if(pageVo.getPageRecord()==100){
                	out.println("<option value='100' selected>100</option>");
                }else{
                	out.println("<option value='100'>100</option>");
                }
                if(pageVo.getPageRecord()==200){
                	out.println("<option value='200' selected>200</option>");
                }else{
                	out.println("<option value='200'>200</option>");
                }
                out.println("</select>条</li>");
                out.println("<li><a href=\'#'\">共"+pageVo.getTotalRecord()+"条,当前是第"+pageVo.getCurrentPage()+"页，共"+pageVo.getTotalPage()+"页</a></li>");
            }

        } catch(Exception e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        super.release();
        this.pageVo = null;
    }

	public PageUtil getPageVo() {
		return pageVo;
	}

	public void setPageVo(PageUtil pageVo) {
		this.pageVo = pageVo;
	}
}