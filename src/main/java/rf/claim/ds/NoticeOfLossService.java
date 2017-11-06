package rf.claim.ds;


import rf.claim.model.ClaimMaterials;
import rf.claim.model.NoticeOfLoss;

/**
 * Created by zhouzheng on 2017/5/1.
 */
public interface NoticeOfLossService {

    public NoticeOfLoss createNoticeOfLoss(NoticeOfLoss notice);

    public NoticeOfLoss loadNoticeOfLoss(String noticeNumber);

    public void upload(ClaimMaterials materials);
}
