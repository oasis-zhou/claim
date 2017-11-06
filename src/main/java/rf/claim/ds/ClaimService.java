package rf.claim.ds;


import rf.claim.model.Claim;

import java.util.List;

/**
 * Created by zhouzheng on 2017/5/1.
 */
public interface ClaimService {

    public Claim createClaim(Claim claim);

    public void saveClaim(Claim claim);

    public void closeClaim(Claim claim);

    public Claim loadClaim(String claimNumber);

    public List<Claim> findClaimsByPolicyNumber(String policyNumber);

    public Claim findLatestClaimByPolicyNumber(String policyNumber);

    public List<Claim> findOpenClaimsByPolicyNumber(String policyNumber);
}
