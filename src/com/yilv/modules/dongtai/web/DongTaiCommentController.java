package com.yilv.modules.dongtai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.common.utils.page.hibernate.HPage;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.entity.DongTaiComment;
import com.yilv.common.web.BaseController;
import com.yilv.modules.dongtai.service.DongTaiCommentService;

@Controller
@RequestMapping("${travelPath}/dongtai/comment")
public class DongTaiCommentController extends BaseController {

	@Autowired
	private DongTaiCommentService commentService;

	@RequestMapping("list")
	@ResponseBody
	private Object list(String dongtaiId, Integer pageNum) {
		HPage<DongTaiComment> page = new HPage<>(pageNum);
		DongTaiComment comment = new DongTaiComment();
		DongTai dongTai = new DongTai();
		dongTai.setId(dongtaiId);
		comment.setDongTai(dongTai);
		commentService.findPageList(comment, false, page, "user", "dongTai");
		return page;
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(String dongtaiId, String content) {
		DongTaiComment comment = new DongTaiComment();
		DongTai dongTai = new DongTai();
		dongTai.setId(dongtaiId);

		comment.setContent(content);
		comment.setDongTai(dongTai);
		comment.setUser(AccountUtils.getAccount());

		commentService.save(comment);

		return new Result(200);
	}
}
