package com.yilv.modules.dongtai.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.entity.DongTaiComment;
import com.yilv.base.modules.dongtai.entity.DongTaiGood;
import com.yilv.base.modules.file.eitity.YFile;
import com.yilv.common.web.BaseController;
import com.yilv.modules.dongtai.service.DongTaiCommentService;
import com.yilv.modules.dongtai.service.DongTaiGoodService;
import com.yilv.modules.file.service.YFileService;

@Controller
@RequestMapping("${travelPath}/dongtai/comment")
public class CommentDongTaiController extends BaseController {
	@Autowired
	private DongTaiGoodService goodService;
	@Autowired
	private DongTaiCommentService commentService;
	@Autowired
	private YFileService fileService;

	@RequestMapping("")
	private String list(DongTai dongTai, Model model) {
		String isGood = "0";
		DongTaiComment comment = new DongTaiComment();
		YFile file = new YFile();
		DongTaiGood good = new DongTaiGood();
		comment.setDongTai(dongTai);
		file.setEntityId(dongTai.getId());
		good.setDongTai(dongTai);
		good.setUser(new Account(AccountUtils.getAccount().getId()));

		List<DongTaiComment> commentList = commentService.findList(comment, false, "dongTai");
		List<YFile> fileList = fileService.findList(file, false);
		List<DongTaiGood> goodList = goodService.findList(good, false, "user", "dongTai");

		if (goodList != null && goodList.size() == 1) {
			isGood = "1";
		}

		model.addAttribute("commentList", commentList);
		model.addAttribute("fileList", fileList);
		model.addAttribute("dongTai", dongTai);
		model.addAttribute("isGood", isGood);

		return "dongtai/comment";
	}

	@RequestMapping("form")
	@ResponseBody
	public Object form(DongTai dongTai) {
		// commentService.save(comment);
		return null;
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(DongTaiComment comment) {
		commentService.save(comment);
		return null;
	}
}
