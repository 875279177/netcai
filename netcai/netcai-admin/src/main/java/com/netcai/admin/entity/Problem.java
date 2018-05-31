package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class Problem implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -1119804616308683180L;
	
	private Long id;
	/**
	 * 问题
	 */
    private String question;
    /**
	 * 答案
	 */
    private String answer;
    /**
	 * 1为买家，2为卖家
	 */
    private Integer type;
    /**
	 * 分类标示
	 */
    private String classify;
    /**
	 * 1为显示；-1为不显示
	 */
    private Integer status;
    /**
	 * 排序
	 */
    private Integer sequence;
    /**
	 * 创建时间
	 */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}